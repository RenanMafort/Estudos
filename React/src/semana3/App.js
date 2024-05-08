import './App.css';
import {Component} from "react";

class App extends Component{

    constructor(props) {
        super(props);
        this.state = { // Onde armazena as variaveis
            titulo: "Primeira página com ClASS Component",
            contador: 0
        }

        this.contador = this.contador.bind(this);//necessario fazer o bind para que a variavel altere
    }

    mudar(){
        console.log("Mudou")
    }

    contador(){
        let state = this.state;
        state.contador++;
        this.setState(state)
    }

    render() { //Obrigatorio ter esse metodo em classes
        return (
            <div>
                <h1>{this.state.titulo}</h1>
                <h2>{this.state.contador}</h2>
                <button onClick={this.mudar} >Click</button>
                <button onClick={this.contador} >Click</button>
            </div>
        )
    }

}

export default App;