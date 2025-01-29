import { FaSearch } from 'react-icons/fa';

const Input = () => {
  return (
    <div className="relative max-w-md">
      <FaSearch className="absolute left-3 top-1/2 transform -translate-y-1/2 w-5 h-5 text-gray-400" />
      <input 
        className="pl-12 pr-8 py-4 w-full bg-gray-900 text-gray-200 rounded-lg focus:outline-none border-2 border-gray-600 placeholder-caption"
        type="text"
        placeholder="Buscar Peliculas o TV Shows"
      />
    </div>
  );
}

export default Input;