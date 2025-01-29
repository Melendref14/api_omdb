import { useState } from 'react';

const Navbar = () => {
  const [isMenuOpen, setIsMenuOpen] = useState(false);

  return (
    <nav className="bg-[#121829] p-4 flex items-center justify-between md:justify-around">
      {/* Logo */}
      <div className="flex items-center">
        <div className="w-10 h-10 rounded-lg flex items-center justify-center">
          <img src="../assets/icon.png" alt="OMDB Logo" className="w-full h-full object-contain" />
        </div>
      </div>
      
      {/* Links de Navegación */}
      <div className={`flex-col md:flex-row md:flex space-y-4 md:space-y-0 md:space-x-6 text-gray-200 font-semibold ${isMenuOpen ? 'flex' : 'hidden'} md:flex`}>
        <a href="#" className="hover:text-white transition">Peliculas</a>
        <a href="#" className="hover:text-white transition">TV Shows</a>
        <a href="#" className="hover:text-white transition flex items-center">
          Sugerencias <span className="ml-1">&rarr;</span>
        </a>
      </div>
      
      {/* Menu boton Mobile */}
      <div className="md:hidden">
        <button 
          className="text-gray-200 hover:text-white transition"
          onClick={() => setIsMenuOpen(!isMenuOpen)}
        >
          <svg className="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M4 6h16M4 12h16m-7 6h7"></path>
          </svg>
        </button>
      </div>
    </nav>
  );
};

export default Navbar;