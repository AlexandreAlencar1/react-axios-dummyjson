import React from 'react';
import { Link } from 'react-router-dom';

function RegistrationPrompt() {
  return (
    <div>
      <p>Olá, faça cadastro para uma experiência personalizada</p>
      <Link to="/user/cadastro">Cadastre-se</Link>
    </div>
  );
}

export default RegistrationPrompt;
