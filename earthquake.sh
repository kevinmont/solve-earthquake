#!/bin/bash
echo "type password for the user root"
cat earthquake.sql | mysql -u root -p
echo "creating dabatase refugio...."
echo "successful"
