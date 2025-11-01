import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { addNote } from '../store/todoSlice';
import '../App.css';

const AddTodo = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const { loading } = useSelector((state) => state.todos);

  const [title, setTitle] = useState('');
  const [content, setContent] = useState('');
  const [creationDate, setCreationDate] = useState('');
  const [status, setStatus] = useState('pending');

  const handleSubmit = async (e) => {
    e.preventDefault();
    const note = {
      title,
      content,
      creationDate,
      status,
    };
    await dispatch(addNote(note));
    navigate('/');
  };

  return (
    <div className="todoapp-root">
      <h1 className="main-title">Yeni Todo Ekle</h1>
      <form className="todo-form" onSubmit={handleSubmit}>
        <input
          className="todo-input"
          type="text"
          placeholder="Title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          required
        />
        <textarea
          className="todo-input"
          placeholder="Description"
          value={content}
          onChange={(e) => setContent(e.target.value)}
          rows={3}
          required
        />
        <input
          className="todo-input"
          type="date"
          value={creationDate}
          onChange={(e) => setCreationDate(e.target.value)}
          required
        />
        <select
          className="todo-input"
          value={status}
          onChange={(e) => setStatus(e.target.value)}
        >
          <option value="pending">Pending</option>
          <option value="in-progress">In Progress</option>
          <option value="completed">Completed</option>
        </select>
        <button className="add-btn" type="submit" disabled={loading}>
          {loading ? 'Ekleniyor...' : 'Todo Ekle'}
        </button>
        <button
          type="button"
          onClick={() => navigate('/')}
          className="add-btn"
          style={{ 
            marginTop: '10px',
            background: 'linear-gradient(90deg, #747d8c 40%, #57606f 100%)'
          }}
        >
          İptal
        </button>
      </form>
    </div>
  );
};

export default AddTodo;


