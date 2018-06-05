#!/bin/sh
set -ex
wget https://github.com/google/protobuf/archive/v3.5.1.tar.gz
tar -xzvf v3.5.1.tar.gz
cd v3.5.1 && ./configure --prefix=/usr && make && sudo make install
