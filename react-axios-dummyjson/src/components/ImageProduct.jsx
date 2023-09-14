import { useState } from "react";

const ImageProduct = () => {
  const [selectedImages, setSelectedImages] = useState([]);

  const handleImageChange = (event) => {
    const files = event.target.files;

    if (files) {
      const imagesArray = Array.from(files).slice(0, 4); // Limita a 4 imagens
      setSelectedImages(imagesArray);
    }
  };

  const handleRemoveImage = (index) => {
    const updatedImages = [...selectedImages];
    updatedImages.splice(index, 1);
    setSelectedImages(updatedImages);
  };

  return (
    <div>
      <label htmlFor="images">Imagens do produto(Até 4)</label>
      <input
        type="file"
        accept="image/*"
        multiple
        onChange={handleImageChange}
      />
      <div className="image-container">
        {selectedImages.map((image, index) => (
          <div className="image-item" key={index}>
            <img
              src={URL.createObjectURL(image)}
              alt={`Imagem ${index}`}
              width="200"
            />
            <button onClick={() => handleRemoveImage(index)}>
              remover Imagens
            </button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default ImageProduct;
