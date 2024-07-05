import { useState } from "react";
import { Textfield } from "../components/textFieldComponent/textfield";
import "./styles/savePages.css"
import { Button } from "../components/buttonComponent/Button";
import { TextareaComponent } from "../components/textareaComponent/textarea";
import axios from "axios";
import { useNavigate } from "react-router-dom";

export const SaveArtisticMovement = () => {
    const navigate = useNavigate();
    const [artmovName, setartmovName] = useState("");

    const [artmovDescription1, setartmovDescription1] = useState("");
    const [artmovDescription2, setartmovDescription2] = useState("");
    const [artmovDescription3, setartmovDescription3] = useState("");

    if (localStorage.getItem('userType') !== 'guide' && localStorage.getItem('userType') !== 'admin') {
        navigate('/');
    }

    const saveartmov = () => {
        axios.post("http://localhost:8082/artisticMovement/saveArtisticMovement", {
            movementName: artmovName,
            text1Movement: artmovDescription1,
            text2Movement: artmovDescription2,
            text3Movement: artmovDescription3
        }).then((response) => {
            console.log(response);
        }).catch((error) => {
            console.log(error);
        });
        setartmovName("");
        setartmovDescription1("");
        setartmovDescription2("");
        setartmovDescription3("");
    }

    return (
        <div className="save-pages-container-outer">
            <div className="save-pages-container">
                <h1>Save Artistic Movement</h1>
                <Textfield headerText="Artistic Movement Name" value={artmovName} setValue={setartmovName} placeholder="Artistic Movement Name" />
                <TextareaComponent label="Artistic Movement Description 1" value={artmovDescription1} onChange={(e: any) => setartmovDescription1(e.target.value)} placeholder="Artistic Movement Description 1" />
                <TextareaComponent label="Artistic Movement Description 2" value={artmovDescription2} onChange={(e: any) => setartmovDescription2(e.target.value)} placeholder="Artistic Movement Description 2" />
                <TextareaComponent label="Artistic Movement Description 3" value={artmovDescription3} onChange={(e: any) => setartmovDescription3(e.target.value)} placeholder="Artistic Movement Description 3" />
                <Button label="Save Artistic Movement" size="medium" onClick={saveartmov}
                    isEnabeld={artmovName !== "" && artmovDescription1 !== "" && artmovDescription2 !== "" && artmovDescription3 !== ""} />
            </div>
        </div>
    );
}