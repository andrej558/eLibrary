import logo from '../../logo.svg';
import './App.css';
import React, {Component} from "react";
import BookAdd from "../Books/BookAdd/bookAdd";
import Books from "../Books/BookList/books";
import ElibraryRepository from "../../repository/elibraryRepository";
import {BrowserRouter as Router, Redirect, Route,Routes} from 'react-router-dom';
import Header from "../Header/header";
import BookEdit from "../Books/BookEdit/bookEdit";

class App extends React.Component
{
    constructor(props)
    {
        super(props);
        this.state={
            books:[],
            authors:[],
            selectedBook:{}
        }
    }
    render()
    {
        return(
            <Router>
                <Header/>
                <main>
                    <Routes>
                    <Route path={"/books/add"} element={<BookAdd authors={this.state.authors} onAddBook={this.addBook}/>}/>
                        <Route path={"/books/edit/:id"} element={<BookEdit authors={this.state.authors} onEditBook={this.editBook} book={this.state.selectedBook}/>}/>
                    <Route path={"/books"} element={<Books books={this.state.books} onDelete={this.deleteBook} onMark={this.markAsTaken} onEdit={this.getBook}/>}/>
                    </Routes>
                </main>
            </Router>
           //<Books books={this.state.books} onDelete={this.deleteBook} onMark={this.markAsTaken}/>
        );
    }
    componentDidMount()
    {
        this.loadBooks();
        this.loadAuthors();
    }
    loadBooks = () =>{
        ElibraryRepository.fetchBooks()
            .then((data)=>{
                this.setState({
                    books:data.data
                })
            })
    }
    deleteBook = (id) =>{
        ElibraryRepository.delete(id)
            .then(()=>{
                this.loadBooks();
            })
    }
    markAsTaken = (id) =>{
        ElibraryRepository.markAsTaken(id)
            .then(()=>{
                this.loadBooks();
            })
    }
    getBook = (id) =>{
        ElibraryRepository.getBook(id)
            .then((data)=>{
                this.setState({
                    selectedBook:data.data
                })
            })
    }
    addBook = (name,availableCopies,category,author) =>{
        ElibraryRepository.addBook(name,availableCopies,category,author)
            .then(()=>{
                this.loadBooks();
            })
    }
    loadAuthors = () =>{
        ElibraryRepository.fetchAuthors()
            .then((data)=>{
                this.setState({
                    authors:data.data
                })
            })
    }
    editBook = (id,name,availableCopies,category,author) =>{
        ElibraryRepository.editBook(id,name,availableCopies,category,author)
            .then(()=>{
                this.loadBooks();
            })
    }
}

export default App;
