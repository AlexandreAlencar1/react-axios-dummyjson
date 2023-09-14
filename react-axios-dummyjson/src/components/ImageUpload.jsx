import { useState } from "react";

const ImageUpload = () => {
  const [selectedImage, setSelectedImage] = useState(null);

  const handleImageChange = (event) => {
    const file = event.target.files[0];

    if (file) {
      setSelectedImage(file);
    }
  };

  const handleRemoveImage = () => {
    setSelectedImage(null);
  };

  return (
    <div>
          <label htmlFor="thumbnail">Fazer upload da Thumbnail :</label>
      <input
        type="file"
        accept="image/*"
        onChange={handleImageChange}
      />
      {selectedImage && (
        <div>
          <label htmlFor="thumbnail">Thumbnail selecionada:</label>
          <img
            src={URL.createObjectURL(selectedImage)}
            alt="Imagem Selecionada"
            width="200"
          />
          <button onClick={handleRemoveImage}>remover Thumbnail</button>
        </div>
      )}
    </div>
  );
};

export default ImageUpload;
