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

# Проверяем наличие директории с джобами
if [ ! -d "./jobs" ]; then
    echo "Error: jobs directory not found!"
    exit 1
fi

echo "Starting jobs update..."
jenkins-jobs --conf ./job.ini update ./jobs

echo "Jobs update completed successfully"