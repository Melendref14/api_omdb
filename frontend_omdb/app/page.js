'use client';

import Navbar from './components/Navbar';
import Input from './components/Input';

export default function Home() {
  return (
    <div>
      <Navbar />
      <div className="ml-2 p-4 mt-8">
        <h1 className="text-3xl text-white font-bold mb-4">
          Peliculas
        </h1>
        <Input />
      </div>
    </div>
  );
}