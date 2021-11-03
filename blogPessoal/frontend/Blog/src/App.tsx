import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import './App.css';
import Home from './pages/Home/Home'
import Footer from './Components/static/footer/Footer';
import Navbar from './Components/static/navbar/Navbar';
import Login from './pages/Login/Login';
import CadastroUsuario from './pages/cadastro/CadastroUsuario';


function App() {
  return (
    <Router>
      <Navbar />
      <Switch>
        <div style={{ minHeight: "100vh"}}>
        <Route exact path="/">
              <Login />
          </Route>
          <Route  path="/login">
              <Login />
          </Route>

          <Route path="/singup" >
            <CadastroUsuario />
          </Route>
          
          <Route path="/home" >
            <Home />
          </Route>
        </div>
      </Switch>

      <Footer />
    </Router>
  );
}

export default App;
