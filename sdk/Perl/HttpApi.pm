package HttpApi;

use LWP::UserAgent;
use JSON;

my $api_host = "http://my.app";    # 修改为API域名  http://finance.aodianyun.com
my $api_key = "3bddc47e7cc05e1d8f488f2562969a33";   # 修改为你的API key


sub post {
    my ($module, $api, %params) = @_;

    my $ua = LWP::UserAgent->new;
    my $auth_str = "dyyadmin:" . $api_key;
    my $query_url = $api_host . "/api/" . $module . "/" . $api;
    my $method = 'POST';
    my $content = encode_json(\%params);

    my $req = HTTP::Request->new($method, $query_url);
    $req->header( 'Accept' => 'application/json' );
    $req->header( 'Content-Type' => 'application/application/json; charset=UTF-8' );
    $req->header( 'Authorization' => $auth_str );
    $req->content( $content );

    my $resp = $ua->request($req);
    if ($resp->is_success) {
        my $message = $resp->decoded_content;
        return decode_json($message);
    } else {
        return (
            'Flag' => '500',
            'FlagString' => 'http请求失败',
            'Error' =>(
                'response_code' => $resp->code,
                'response' => $resp->message,
            )
        );
    }

    
}