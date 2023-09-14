import { useState } from "react";

const Filter = () => {
  // Definindo o estado para rastrear a opção selecionada
  const [selectedOption, setSelectedOption] = useState("");

  // Função para lidar com a mudança de seleção
  const handleSelectChange = (event) => {
    setSelectedOption(event.target.value);
  };

  return (
    <div>
      <label htmlFor="category">Selecione uma categoria</label>
      <select value={selectedOption} onChange={handleSelectChange}>
      <option value="">Selecione uma opção</option>
        <option value="smartphones">Smartphones</option>
        <option value="laptops">Laptops</option>
        <option value="fragrances">Fragrâncias</option>
        <option value="skincare">Cuidados com a Pele</option>
        <option value="groceries">Produtos de Mercearia</option>
        <option value="home-decoration">Decoração de Casa</option>
        <option value="furniture">Mobiliário</option>
        <option value="tops">Tops</option>
        <option value="womens-dresses">Vestidos Femininos</option>
        <option value="womens-shoes">Calçados Femininos</option>
        <option value="mens-shirts">Camisas Masculinas</option>
        <option value="mens-shoes">Calçados Masculinos</option>
        <option value="mens-watches">Relógios Masculinos</option>
        <option value="womens-watches">Relógios Femininos</option>
        <option value="womens-bags">Bolsas Femininas</option>
        <option value="womens-jewellery">Joias Femininas</option>
        <option value="sunglasses">Óculos de Sol</option>
        <option value="automotive">Automóveis</option>
        <option value="motorcycle">Motocicletas</option>
        <option value="lighting">Iluminação</option>
        {/* Adicione o restante das opções aqui */}
      </select>
      {selectedOption && <p>Você selecionou: {selectedOption}</p>}
    </div>
  );
}

export default Filter;
