import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

export default function EditUser() {
  let navigate = useNavigate();

  const { idUser } = useParams();

  const [user, setUser] = useState({
    name: "",
    email: "",
    password: "",
  });

  const { name, email, password } = user;

  const onInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  useEffect(() => {
    loadUser();
  }, []);

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.put(`http://localhost:8080/users/user/${idUser}`, user);
    navigate("/");
  };

  const loadUser = async () => {
    try {
      const result = await axios.get(`http://localhost:8080/users/user/${idUser}`);
      setUser(result.data);
    } catch (error) {
      console.error("Erro na requisição GET:", error);
    }
  };
  

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Edit User</h2>

          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
                Nome
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Seu Nome"
                name="name"
                value={name}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="email" className="form-label">
                E-mail
              </label>
              <input
                type={"email"}
                className="form-control"
                placeholder="Seu E-mail"
                name="email"
                value={email}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Password" className="form-label">
                 Password
              </label>
              <input
                type={"password"}
                className="form-control"
                placeholder="Sua Senha"
                name="password"
                value={password}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <Link className="btn btn-outline-danger mx-2" to="/">
              Cancelar
            </Link>
            <button type="submit" className="btn btn-outline-primary">
              Enviar
            </button>
          </form>
        </div>
      </div>
    </div>
  );
}
