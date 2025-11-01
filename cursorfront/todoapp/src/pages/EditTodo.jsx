import React, { useState, useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate, useParams } from 'react-router-dom';
import { findNoteById, updateNote } from '../store/todoSlice';
import '../App.css';

const EditTodo = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const { id } = useParams();
  const { selectedNote, loading } = useSelector((state) => state.todos);

  const [title, setTitle] = useState('');
  const [content, setContent] = useState('');
  const [creationDate, setCreationDate] = useState('');
  const [status, setStatus] = useState('pending');

  useEffect(() => {
    dispatch(findNoteById(parseInt(id)));
  }, [dispatch, id]);

  useEffect(() => {
    if (selectedNote) {
      setTitle(selectedNote.title || '');
      setContent(selectedNote.content || '');
      setCreationDate(selectedNote.creationDate || '');
      setStatus(selectedNote.status || 'pending');
    }
  }, [selectedNote]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    const updatedNote = {
      title,
      content,
      creationDate,
      status,
    };
    await dispatch(updateNote({ id: parseInt(id), updatedNote }));
    navigate('/');
  };

  if (loading && !selectedNote) {
    return <div className="todoapp-root"><div className="empty-message">Yükleniyor...</div></div>;
  }

  return (
    <div className="todoapp-root">
      <h1 className="main-title">Todo Düzenle</h1>
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
        />
        <input
          className="todo-input"
          type="date"
          value={creationDate}
          onChange={(e) => setCreationDate(e.target.value)}
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
          {loading ? 'Güncelleniyor...' : 'Güncelle'}
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

export default EditTodo;


