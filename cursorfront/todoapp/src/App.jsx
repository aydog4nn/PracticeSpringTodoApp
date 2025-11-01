import React from 'react';
import { Routes, Route } from 'react-router-dom';
import TodoList from './pages/TodoList';
import AddTodo from './pages/AddTodo';
import EditTodo from './pages/EditTodo';
import './App.css';

function App() {
  return (
    <Routes>
      <Route path="/" element={<TodoList />} />
      <Route path="/add" element={<AddTodo />} />
      <Route path="/edit/:id" element={<EditTodo />} />
    </Routes>
  );
}

export default App;
