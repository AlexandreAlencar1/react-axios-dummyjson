import { Link } from "react-router-dom"
//a navegação é toda feita através do Link pra não ter o reload
import './Navbar.css'

const Navbar = () => {
  return (
    <nav className="navbar">
        <h2>
            <Link to={'/'}>Products Home </Link> 
        </h2>
        <ul>
            <li>
            <Link to={'/'}>Home</Link>
            </li>
        </ul>
    </nav>
  )
}

export default Navbar