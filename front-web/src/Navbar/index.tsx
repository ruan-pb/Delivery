import './styles.css'
import {ReactComponent as Logo} from './logo.svg';
function Navbar(){
    return(
        <nav className="main-nav-bar">

            <Logo/>
            <a href="home" className="Logo-text">DS Delivery</a>
        </nav>
    )

}

export default Navbar;