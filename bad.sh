#!/usr/bin/env bash

address=localhost
req="GET 127.0.0.1/user HTTP/1.1
Host: www.nowhere123.com
Accept: text/html
Accept-Language: en-us
Accept-Encoding: utf-8, gzip, deflate
User-Agent: Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)"

while true; do
    echo telnet ${address} 8080
    echo ${req}
done