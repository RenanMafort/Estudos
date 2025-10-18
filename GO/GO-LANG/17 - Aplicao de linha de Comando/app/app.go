package app

import (
	"fmt"
	"github.com/urfave/cli"
	"log"
	"net"
)

func Gerar() *cli.App {

	app := cli.NewApp()

	app.Name = "Aplicação de linha de comando"
	app.Usage = "Recuperar o ip e nomes de servidores da WEB"

	flags := []cli.Flag{
		cli.StringFlag{
			Name:  "host",
			Value: "devbook.com.br",
		},
	}

	app.Commands = []cli.Command{
		{
			Name:   "ip",
			Usage:  "Busca ips de endereço na internet",
			Flags:  flags,
			Action: listarIps,
		},
		{
			Name:   "nameserver",
			Usage:  "Buscar nome dos servidores",
			Flags:  flags,
			Action: buscarNomeServidores,
		},
	}

	return app
}

func listarIps(c *cli.Context) {
	host := c.String("host")
	ips, erro := net.LookupIP(host)

	if erro != nil {
		log.Fatal(erro)
	}

	for _, value := range ips {
		fmt.Println(value)
	}
}

func buscarNomeServidores(c *cli.Context) {
	host := c.String("host")

	sn, erro := net.LookupNS(host)
	if erro != nil {
		log.Fatal(erro)
	}

	for _, value := range sn {
		fmt.Println(value.Host)
	}

}
