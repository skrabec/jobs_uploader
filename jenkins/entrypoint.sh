#!/bin/bash

set -e  # Останавливаем скрипт при любой ошибке

echo "Creating configuration file..."
sh """cat <<EOF > ./job.ini
[jenkins]
url=http://45.132.17.22:8080/jenkins/
user=admin
password=admin
[job_builder]
ignore_cache=True
keep_descriptions=True
recursive=True
EOF"""

