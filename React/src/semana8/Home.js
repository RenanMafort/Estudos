import React, {Component} from "react";
import firebase from "firebase/app";

class Principal extends Component{
    constructor(props) {
        super(props);
        this.state = {
            nome:""
        }
    }

    async componentDidMount(){
        await firebase.auth().onAuthStateChanged(async (usuario) =>{
            if (usuario){
                var id = usuario.uid;
                await firebase.firestore().collection("usuario").doc(id).get()
                    .then((retorno) => {
                       this.setState({
                           nome: retorno.data().nome
                       })
                    })
            }
        })
    }

    render() {
        return(
            <div>
                <h1>Olá, {this.state.nome}</h1>
            </div>
        )
    }
}

export default Principal;