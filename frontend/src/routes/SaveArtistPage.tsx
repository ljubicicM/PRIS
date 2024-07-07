import { useState } from "react";
import { Textfield } from "../components/textFieldComponent/textfield";
import "./styles/savePages.css"
import { Button } from "../components/buttonComponent/Button";
import { TextareaComponent } from "../components/textareaComponent/textarea";
import axios from "axios";
import { useNavigate } from "react-router-dom";

export const SaveArtistPage = () => {
    const navigate = useNavigate();

    const [artistName, setartistName] = useState("");
    const [artistLastName, setartistLastName] = useState("");

    const [artistDescription1, setartistDescription1] = useState("");
    const [artistDescription2, setartistDescription2] = useState("");
    const [artistDescription3, setartistDescription3] = useState("");

    if (localStorage.getItem('userType') !== 'guide' && localStorage.getItem('userType') !== 'admin') {
        navigate('/');
    }

    const saveartist = () => {
        axios.post("http://localhost:8082/author/saveAuthor", {
            nameAuthor: artistName,
            surnameAuthor: artistLastName,
            text1Author: artistDescription1,
            text2Author: artistDescription2,
            text3Author: artistDescription3
        }).then((response) => {
            console.log(response);
        }).catch((error) => {
            console.log(error);
        });
        setartistName("");
        setartistDescription1("");
        setartistDescription2("");
        setartistDescription3("");
    }

    return (
        <div className="save-pages-container-outer">
            <div className="save-pages-container">
                <h1>Save Artist</h1>
                <Textfield headerText="Artist Name" value={artistName} setValue={setartistName} placeholder="Artist Name" />
                <Textfield headerText="Artist Last Name" value={artistLastName} setValue={setartistLastName} placeholder="Artist Last Name" />
                <TextareaComponent label="Artist Description 1" value={artistDescription1} onChange={(e: any) => setartistDescription1(e.target.value)} placeholder="Artist Description 1" />
                <TextareaComponent label="Artist Description 2" value={artistDescription2} onChange={(e: any) => setartistDescription2(e.target.value)} placeholder="Artist Description 2" />
                <TextareaComponent label="Artist Description 3" value={artistDescription3} onChange={(e: any) => setartistDescription3(e.target.value)} placeholder="Artist Description 3" />
                <Button label="Save Artist" size="medium" onClick={saveartist}
                    isEnabeld={artistName !== "" && artistDescription1 !== "" && artistDescription2 !== "" && artistDescription3 !== ""} />
            </div>
        </div>
    );
}