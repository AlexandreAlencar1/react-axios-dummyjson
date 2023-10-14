import React from 'react';

export default function Header() {
  return (
    <div>

      <div className="input-group mb-3">
        <input 
          type="text"
          className="form-control"
          placeholder="Busque na Loja XXX"
          aria-label="Recipient's username"
          aria-describedby="button-addon2"
        />
        <div className="input-group-append ">
          <button className="btn btn-outline-secondary" type="button" id="button-addon2">Buscar</button>
        </div>
      </div>

    </div>
  );
}
