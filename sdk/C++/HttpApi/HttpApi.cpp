// HttpApi.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"

#include <cpprest\http_client.h>
#include <iostream>
#include <locale.h>
#include <string>

using namespace std;
using namespace utility;
using namespace web;
using namespace web::http;
using namespace web::http::client;
using namespace concurrency;

std::wstring s2ws(const std::string& s);
json::value HttpApiPost(wstring module, wstring api, json::value params);

wstring s2ws(const string& s) {
	size_t convertedChars = 0;
	string curLocale = setlocale(LC_ALL, NULL);   //curLocale="C"
	setlocale(LC_ALL, "chs");
	const char* source = s.c_str();
	size_t charNum = sizeof(char)*s.size() + 1;
	wchar_t* dest = new wchar_t[charNum];
	mbstowcs_s(&convertedChars, dest, charNum, source, _TRUNCATE);
	wstring result = dest;
	delete[] dest;
	setlocale(LC_ALL, curLocale.c_str());
	return result;
}

json::value HttpApiPost(wstring module, wstring api, json::value params)
{
	const auto api_host = L"http://my.app";    // 修改为API域名  http ://finance.aodianyun.com
	const auto api_key = L"3bddc47e7cc05e1d8f488f2562969a33";   //  修改为你的API key

	wstring query_path = L"/api/";
	query_path += module;
	query_path += L"/";
	query_path += api;

	wstring auth_str = L"dyyadmin:";
	auth_str += api_key;

	auto content = params.serialize();

	http_client client(api_host);
	uri_builder builder(query_path);

	http_response response = client.request(methods::POST, builder.to_string(), content, L"application/application/json; charset=UTF-8").get();
	auto response_code = response.status_code();
	wstring response_error = L"";
	if (response_code == status_codes::OK)
	{
		try
		{
			const json::value& json_value = response.extract_json().get();
			return json_value;
		}
		catch (const std::exception& e)
		{
			response_error = s2ws(e.what());
			wcout << response_error << endl;
		}
	}

	json::value error_info;
	error_info[L"response_code"] = json::value::number(response_code);
	error_info[L"response_error"] = json::value::string(response_error);

	json::value error_value;
	error_value[L"Flag"] = json::value::number(500);
	error_value[L"FlagString"] = json::value::string(L"http请求失败");
	return error_value;
}


int main()
{
	json::value test_1_args;
	test_1_args[L"room_id"] = json::value::number(73);
	test_1_args[L"expire"] = json::value::number(1000);
	test_1_args[L"uid"] = json::value::string(L"234234");
	test_1_args[L"nick"] = json::value::string(L"ttt");
	test_1_args[L"ava"] = json::value::string(L"");

	auto test_1 = HttpApiPost(L"RoomMgr", L"getAuthToken", test_1_args);
	wcout << L"test_1 " << test_1.serialize() << endl;

	json::value test_2_args;
	test_1_args[L"token"] = json::value::string(test_1.at(L"Info").as_string());
	test_1_args[L"page"] = json::value::number(1);
	test_1_args[L"num"] = json::value::number(20);

	auto test_2 = HttpApiPost(L"JiaoYuUserInfo", L"listWisDoc", test_2_args);
	wcout << L"test_2 " << test_2.serialize() << endl;

	return 0;
}

