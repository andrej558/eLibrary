import axios from '../custom-axios/axios'

const ELibraryService={
    fetchBooks:()=>{
        return axios.get('/books');
    },
    delete:(id)=>{
        return axios.delete(`/books/delete/${id}`);
    },
    markAsTaken:(id)=>{
        return axios.get(`/books/markastaken/${id}`);
    },
    addBook:(name,availableCopies,category,author)=>{
        return axios.post("/books/add",{
            "name":name,
            "availableCopies":availableCopies,
            "category":category,
            "author":author
        });
    },
    fetchAuthors:()=>{
        return axios.get("/authors");
    },
    editBook:(id,name,availableCopies,category,author)=>{
        return axios.post(`/books/edit/${id}`,{
            "name":name,
            "availableCopies":availableCopies,
            "category":category,
            "author":author
        })
    },
    getBook:(id)=>{
        return axios.get(`/books/${id}`);
    }

}
export default ELibraryService;