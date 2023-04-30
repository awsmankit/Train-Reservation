import React from "react"
import logo from '../images/logo.jpg'

const Header =(props) => {
    return ( <div >
<nav class="navbar navbar-expand-lg navbar-light bg-light container-fluid">
  <a class="navbar-brand" href="#">
  <img src={logo} alt="" width="50"/>
SAFAR
</a>
  <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="/Home">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/UpdateUser">Profile</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/Signin">Logout</a>
    </li>
  
    </ul>
  </div>
</nav>
</div>
    );
};
export default Header;