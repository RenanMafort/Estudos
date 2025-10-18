package main

import (
	"html/template"
	"log"
	"net/http"
)

var templates *template.Template

type pessoa struct {
	Nome      string
	SobreNome string
}

func main() {
	templates = template.Must(template.ParseGlob("22-HTML/*.html"))
	http.HandleFunc("/home", func(w http.ResponseWriter, r *http.Request) {

		p1 := pessoa{"Renan", "Mafort"}

		err := templates.ExecuteTemplate(w, "home.html", p1)
		if err != nil {
			return
		}
	})

	log.Fatal(http.ListenAndServe(":5000", nil))
}
