import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import api from '../services/api';

// Async Thunks
export const getAllNotes = createAsyncThunk(
  'todos/getAllNotes',
  async (note = {}) => {
    const response = await api.get('/get-all-notes', { params: note });
    return response.data;
  }
);

export const addNote = createAsyncThunk(
  'todos/addNote',
  async (note) => {
    const response = await api.post('/add-note', note);
    return response.data;
  }
);

export const findNoteById = createAsyncThunk(
  'todos/findNoteById',
  async (id) => {
    const response = await api.get(`/find/${id}`);
    return response.data;
  }
);

export const deleteNote = createAsyncThunk(
  'todos/deleteNote',
  async (id) => {
    await api.delete(`/delete/${id}`);
    return id;
  }
);

export const updateNote = createAsyncThunk(
  'todos/updateNote',
  async ({ id, updatedNote }) => {
    const response = await api.put(`/update-note/${id}`, updatedNote);
    return response.data;
  }
);

// Slice
const todoSlice = createSlice({
  name: 'todos',
  initialState: {
    items: [],
    selectedNote: null,
    loading: false,
    error: null,
  },
  reducers: {
    clearSelectedNote: (state) => {
      state.selectedNote = null;
    },
  },
  extraReducers: (builder) => {
    builder
      // GetAllNotes
      .addCase(getAllNotes.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(getAllNotes.fulfilled, (state, action) => {
        state.loading = false;
        state.items = action.payload;
      })
      .addCase(getAllNotes.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      })
      // AddNote
      .addCase(addNote.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(addNote.fulfilled, (state, action) => {
        state.loading = false;
        state.items.push(action.payload);
      })
      .addCase(addNote.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      })
      // FindNoteById
      .addCase(findNoteById.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(findNoteById.fulfilled, (state, action) => {
        state.loading = false;
        state.selectedNote = action.payload;
      })
      .addCase(findNoteById.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      })
      // DeleteNote
      .addCase(deleteNote.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(deleteNote.fulfilled, (state, action) => {
        state.loading = false;
        state.items = state.items.filter(item => item.id !== action.payload);
      })
      .addCase(deleteNote.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      })
      // UpdateNote
      .addCase(updateNote.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(updateNote.fulfilled, (state, action) => {
        state.loading = false;
        const index = state.items.findIndex(item => item.id === action.payload.id);
        if (index !== -1) {
          state.items[index] = action.payload;
        }
      })
      .addCase(updateNote.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message;
      });
  },
});

export const { clearSelectedNote } = todoSlice.actions;
export default todoSlice.reducer;


