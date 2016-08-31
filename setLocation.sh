#!/bin/bash

echo yourSpinIsHoldingYouBack > ~/.emulator_console_auth_token
/usr/bin/expect << EOD
set timeout 200
spawn telnet  localhost 5554
expect "OK"
send "auth yourSpinIsHoldingYouBack\r"
expect "OK"
send "geo fix -74 40\r"
expect "OK"
#rest of your logic what you want.