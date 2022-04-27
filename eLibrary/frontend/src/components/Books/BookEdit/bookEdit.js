import React from 'react';
import {useNavigate} from 'react-router-dom';

const BookEdit = (props) => {

    const navigate = useNavigate();
    const arr=["NOVEL","THRILER","HISTORY","FANTASY","BIOGRAPHY","CLASSICS","DRAMA"];
    const [formData, updateFormData] = React.useState({
        name: "",
        availableCopies: 0,
        category: 1,
        author: 1
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name !== "" ? formData.name : props.book.name;
        const availableCopies = formData.availableCopies !== 0 ? formData.availableCopies : props.book.availableCopies;
        //const category = formData.category !== 0 ? formData.category : props.book.category;
        const category = formData.category !== 0 ? formData.category : arr.indexOf(props.book.category) - 1;
        const author = formData.author !== 0 ? formData.author : props.book.author;

        props.onEditBook(props.book.id,name,availableCopies,category,author);
        navigate('/books');
    }

    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Book name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder={props.book.name}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="availableCopies">availableCopies</label>
                        <input type="text"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               placeholder={props.book.availableCopies}
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="category">Category</label>
                        <select id="category" name="category" className="form-control" onChange={handleChange}>
                            <option value="-1" selected disabled>Click Here</option>
                            <option value="0">NOVEL</option>
                            <option value="1">THRILER</option>
                            <option value="2">HISTORY</option>
                            <option value="3">FANTASY</option>
                            <option value="4">BIOGRAPHY</option>
                            <option value="5">CLASSICS</option>
                            <option value="6">DRAMA</option>
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Author</label>
                        <select name="author" className="form-control" onChange={handleChange}>
                            {props.authors.map((term) => {
                                if(props.book.author !== undefined &&
                                    props.book.author.id === term.id)
                                    return <option selected={props.book.author.id} value={term.id}>{term.name}</option>
                                else return <option value={term.id}>{term.name}</option>
                            })}

                        </select>
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
}
export default BookEdit;