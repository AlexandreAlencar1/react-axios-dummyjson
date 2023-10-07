import axios from "axios";
import React, { useEffect,useState } from "react";
import { Link, useParams } from "react-router-dom";

export default function ViewUser() {
  const [user, setUser] = useState({
    name: "",
    email: "",
    password: "",
  });

  const { idUser } = useParams();

  useEffect(() => {
    loadUser();
  }, []);

  const loadUser = async () => {
    const result = await axios.get(`http://localhost:8080/users/user/${idUser}`);
    setUser(result.data);
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Detalhes do Usuário</h2>

          <div className="card">
            <div className="card-header">
            Detalhes do Usuário id : {user.idUser}
              <ul className="list-group list-group-flush">
                <li className="list-group-item">
                  <b>Nome:</b>
                  {user.name}
                </li>
                <li className="list-group-item">
                  <b>Email:</b>
                  {user.email}
                </li>
                <li className="list-group-item">
                  <b>Senha:</b>
                  {user.password}
                </li>
              </ul>
            </div>
          </div>
          <Link className="btn btn-primary my-2" to={"/"}>
            Página Inicial
          </Link>
        </div>
      </div>
    </div>
  );
}
