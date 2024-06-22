import { useState } from "react";
import { Textfield } from "../components/textFieldComponent/textfield";
import "./styles/savePages.css"
import { Button } from "../components/buttonComponent/Button";
import { TextareaComponent } from "../components/textareaComponent/textarea";

export const SaveEpochPage = () => {

    const [epochName, setEpochName] = useState("");

    const [epochDescription1, setEpochDescription1] = useState("");
    const [epochDescription2, setEpochDescription2] = useState("");
    const [epochDescription3, setEpochDescription3] = useState("");

    const saveEpoch = () => {
        console.log(epochDescription3);
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