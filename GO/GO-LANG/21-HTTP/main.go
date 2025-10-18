package main

import (
	"log"
	"net/http"
)

func inicio(w http.ResponseWriter, r *http.Request) {
	w.Write([]byte("Hello World!"))
}

func home(w http.ResponseWriter, r *http.Request) {
	w.Write([]byte("Hello Home!"))
}

func main() {

	http.HandleFunc("/", inicio)
	http.HandleFunc("/home", home)

	log.Fatal(http.ListenAndServe(":5000", nil))
}
