import { FaStar } from 'react-icons/fa';

const MovieCard = ({ title, poster, personalRating, year }) => {
  return (
    // Contenedor principal de la tarjeta de película
    <div className="relative bg-gray-800 rounded-lg p-3 shadow-lg w-46 h-92 m-2">
      {/* Contenedor del rating con icono de estrella */}
      <div className="absolute top-2 left-2 bg-yellow-500 text-white text-sm px-2 py-1 rounded flex items-center">
        <FaStar className="mr-1" /> {personalRating}
      </div>
      
      {/* Contenedor de la imagen de la película */}
      <div className="flex justify-center">
        <img src={poster} alt={title} className="w-full h-64 object-cover rounded-lg shadow-md" />
      </div>
      
      {/* Contenedor del título y año de la película */}
      <div className="mt-4 text-center">
        <h2 className="text-lg font-bold text-white">{title}</h2>
        <p className="text-sm text-gray-400">{year}</p>
      </div>
    </div>
  );
};

export default MovieCard;