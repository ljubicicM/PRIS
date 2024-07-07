import { useState } from "react";
import { Textfield } from "../components/textFieldComponent/textfield";
import "./styles/savePages.css"
import { Button } from "../components/buttonComponent/Button";
import { TextareaComponent } from "../components/textareaComponent/textarea";
import axios from "axios";
import { useNavigate } from "react-router-dom";

export const SaveEpochPage = () => {
    const navigate = useNavigate();
    const [epochName, setEpochName] = useState("");

    if (localStorage.getItem('userType') !== 'guide' && localStorage.getItem('userType') !== 'admin') {
        navigate('/');
    }
    
    const [epochDescription1, setEpochDescription1] = useState("");
    const [epochDescription2, setEpochDescription2] = useState("");
    const [epochDescription3, setEpochDescription3] = useState("");

    const saveEpoch = () => {
        axios.post("http://localhost:8082/epoch/saveEpoch", {
            epochName: epochName,
            text1Epoch: epochDescription1,
            text2Epoch: epochDescription2,
            text3Epoch: epochDescription3
        }).then((response) => {
            console.log(response);
        }).catch((error) => {
            console.log(error);
        });
        setEpochName("");
        setEpochDescription1("");
        setEpochDescription2("");
        setEpochDescription3("");
    }

    return (
        <div className="save-pages-container-outer">
            <div className="save-pages-container">
                <h1>Save Epoch</h1>
                <Textfield headerText="Epoch Name" value={epochName} setValue={setEpochName} placeholder="Epoch Name" />
                <TextareaComponent label="Epoch Description 1" value={epochDescription1} onChange={(e: any) => setEpochDescription1(e.target.value)} placeholder="Epoch Description 1" />
                <TextareaComponent label="Epoch Description 2" value={epochDescription2} onChange={(e: any) => setEpochDescription2(e.target.value)} placeholder="Epoch Description 2" />
                <TextareaComponent label="Epoch Description 3" value={epochDescription3} onChange={(e: any) => setEpochDescription3(e.target.value)} placeholder="Epoch Description 3" />
                <Button label="Save Epoch" size="medium" onClick={saveEpoch}
                    isEnabeld={epochName !== "" && epochDescription1 !== "" && epochDescription2 !== "" && epochDescription3 !== ""} />
            </div>
        </div>
    );
}