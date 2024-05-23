from python:3

run apt-get update -y && apt-get install -y python3-pip python-dev-is-python3

workdir /app

RUN pip install Flask

copy . .

EXPOSE 5000

CMD ["python","./app.py"]