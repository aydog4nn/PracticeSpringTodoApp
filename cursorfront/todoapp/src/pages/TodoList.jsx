import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { getAllNotes, deleteNote } from '../store/todoSlice';
import { useNavigate } from 'react-router-dom';
import '../App.css';

const TodoList = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const { items, loading, error } = useSelector((state) => state.todos);

  useEffect(() => {
    dispatch(getAllNotes());
  }, [dispatch]);

  const handleDelete = async (id) => {
    if (window.confirm('Bu todo\'yu silmek istediğinize emin misiniz?')) {
      await dispatch(deleteNote(id));
      dispatch(getAllNotes()); // Listeyi yeniden yükle
    }
  };

  if (loading) return <div className="todoapp-root"><div className="empty-message">Yükleniyor...</div></div>;
  if (error) return <div className="todoapp-root"><div className="empty-message">Hata: {error}</div></div>;

  return (
    <div className="todoapp-root">
      <h1 className="main-title">🌱 Spring Todo App</h1>
      <button 
        onClick={() => navigate('/add')} 
        className="add-btn"
        style={{ marginBottom: '20px', width: '200px' }}
      >
        Yeni Todo Ekle
      </button>
      <div className="todos-list">
        {items.length === 0 ? (
          <div className="empty-message">Henüz todo yok. Yeni bir tane ekleyin!</div>
        ) : (
          items.map((todo) => (
            <div className="todo-card" key={todo.id}>
              <div className="todo-header">
                <span className="todo-title">{todo.title}</span>
                <span className={`status-pill status-${todo.status || 'pending'}`}>
                  {todo.status || 'pending'}
                </span>
              </div>
              <div className="todo-desc">{todo.description}</div>
              {todo.dueDate && <div className="todo-date">Due: {todo.dueDate}</div>}
              <div style={{ marginTop: '10px', display: 'flex', gap: '10px' }}>
                <button
                  onClick={() => navigate(`/edit/${todo.id}`)}
                  className="add-btn"
                  style={{ padding: '5px 15px', fontSize: '14px' }}
                >
                  Düzenle
                </button>
                <button
                  onClick={() => handleDelete(todo.id)}
                  className="add-btn"
                  style={{ 
                    padding: '5px 15px', 
                    fontSize: '14px',
                    background: 'linear-gradient(90deg, #ff4757 40%, #ff6b7a 100%)'
                  }}
                >
                  Sil
                </button>
              </div>
            </div>
          ))
        )}
      </div>
    </div>
  );
};

export default TodoList;


