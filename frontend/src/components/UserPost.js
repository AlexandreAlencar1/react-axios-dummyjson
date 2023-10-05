import axios from 'axios'; // Importe a biblioteca Axios
import React, { useState, useEffect } from 'react';

function UserForm() {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    senha: '',
  });

  const [userId, setUserId] = useState(null); // Estado para armazenar o ID do usuário criado
  const [userDetails, setUserDetails] = useState(null); // Estado para armazenar os detalhes do usuário

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    // Enviar os dados do formulário para o servidor usando Axios
    axios
      .post('http://localhost:8080/users', formData)
      .then((response) => {
        // Obtenha o ID do usuário retornado pela criação
        const { id } = response.data;
        setUserId(id);
        // Após a criação, busque os detalhes do usuário automaticamente
        return axios.get(`http://localhost:8080/users/1`);
      })
      .then((userResponse) => {
        setUserDetails(userResponse.data);
      })
      .catch((error) => {
        console.error('Erro ao criar usuário:', error);
      });
  };

  return (
    <div>
      <h2>Cadastro de Usuário</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Nome:</label>
          <input
            type="text"
            name="name"
            value={formData.name}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>E-mail:</label>
          <input
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Senha:</label>
          <input
            type="password"
            name="senha"
            value={formData.senha}
            onChange={handleChange}
          />
        </div>
        <button type="submit">Cadastrar</button>
      </form>

      {userDetails && (
        <div>
          <h2>Detalhes do Usuário</h2>
          <p>Nome: {userDetails.name}</p>
          <p>E-mail: {userDetails.email}</p>
        </div>
      )}
    </div>
  );
}

export default UserForm;
