FROM ubuntu:latest
RUN apt-get update && apt-get install apache2 openssl curl net-tools iputils-ping -y && \
    apt-get clean  && rm -rf /var/lib/apt/lists/*
RUN a2enmod ssl proxy proxy_http headers rewrite
COPY certs/book.crt /etc/ssl/certs/book.crt
COPY certs/book.key /etc/ssl/private/book.key
COPY book.conf /etc/apache2/sites-available/
RUN a2ensite book.conf
RUN apache2ctl configtest 
CMD ["apache2ctl", "-D", "FOREGROUND"]
