import {Component} from "react";
import firebase from "./FireBase";

class Formulario extends Component{
    id = 0
    constructor(props) {
        super(props);
        this.state = {
            email: "",
            senha:"",
            nome: "",
            sobrenome: ""
        }

        this.gravar = this.gravar.bind(this);
        this.consultar()
    }

    async gravar(){

        // firebase.firestore().collection("usuario") AQUI O FIREBASE GERA UM INDICE ALEATORIO
        //     .add({
        //         nome: this.state.nome,
        //         sobrenome: this.state.sobrenome
        //     })

        await firebase.firestore().collection("usuario").doc(this.id.toString()) // AQUI COLOCAMOS O INDICE
            .set({
                nome: this.state.nome,
                sobrenome: this.state.sobrenome
            })

     }
    render() {
        return(
            <div>
                <div>
                    <h1>Página de Cadastro</h1>
                    <input type="text" placeholder="E-mail" onChange={(e) => this.setState({email: e.target.value})} />
                    <br/>
                    <input type="password" placeholder="Senha" onChange={(e) => this.setState({senha: e.target.value})} />
                    <br/>
                    <input type="text" placeholder="Nome" onChange={(e) => this.setState({nome: e.target.value})} />
                    <br/>
                    <input type="text" placeholder="Sobre Nome" onChange={(e) => this.setState({sobrenome: e.target.value})} />
                    <br/>
                    <button onClick={this.gravar} >Gravar</button>
                </div>
                <h1>Página de Consulta</h1>
            </div>
        )
    }
}

export default Formulario