import { useState } from 'react';
import { FaFilter } from 'react-icons/fa';

const Filter = ({ onSortChange }) => {
  // Estado local para almacenar el valor de ordenación seleccionado
  const [sort, setSort] = useState('');

  // Manejador de eventos para cambiar el valor de ordenación
  const handleSortChange = (event) => {
    setSort(event.target.value);
    onSortChange(event.target.value); // Llama a la función pasada como prop para actualizar el estado en el componente padre
  };

  return (
    <div className="relative w-full max-w-xs">
      <div className="relative">
        {/* Icono de filtro */}
        <FaFilter className="absolute left-3 top-1/2 transform -translate-y-1/2 w-5 h-5 text-gray-400" />
        {/* Selector de ordenación */}
        <select
          id="sort"
          value={sort}
          onChange={handleSortChange}
          className="pl-12 pr-8 py-4 w-full bg-gray-900 text-gray-400 text-sm rounded-lg focus:outline-none border-2 border-gray-600 placeholder-caption"
        >
          <option value="year-asc">Año "Asc"</option>
          <option value="year-desc">Año "Desc"</option>
          <option value="rating-asc">Valoración "Asc"</option>
          <option value="rating-desc">Valoración "Desc"</option>
        </select>
      </div>
    </div>
  );
};

export default Filter;