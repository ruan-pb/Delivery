import './styles.css'
import { ReactComponent as Logo } from './logo.svg';
import { ReactComponent as MainImage } from './main.svg';
import Footer from '../Footer';
function Home() {
    return (
        <>
            <div className="home-container">

                <div className="home-content">
                    <div className="home-actions">
                        <h1 className="home-title">

                            Faça seu pedido<br /> que entregamos<br /> pra você!!!
                            
                    </h1>
                        <h3 className="home-subtitle">
                            Escolha o seu pedido e em poucos minutos <br /> levaremos até sua porta<br />
                        </h3>

                        <a href="ordres" className="home-btt-order">
                            Fazer Pedido
                         </a>

                    </div>
                    <div className="home-image">
                        <MainImage />

                    </div>
                </div>


            </div>

            <Footer/>

        </>
    )

}

export default Home;