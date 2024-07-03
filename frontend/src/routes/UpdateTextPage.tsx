/* eslint-disable eqeqeq */
import { useEffect, useState } from "react";
import { Dropdown } from "../components/dropdownComponent/dropdown";
import { TextareaComponent } from "../components/textareaComponent/textarea";
import { Button } from "../components/buttonComponent/Button";
import axios from "axios";

export const UpdateTextPage = () => {
    const [selectedOption, setSelectedOption] = useState(1);
    const [selectGenerality, setSelectGenerality] = useState(1);
    const [text, setText] = useState("");
    const [isInitialized, setIsInitialized] = useState(false);
    const [artisticMovements, setArtisticMovements] = useState([]);
    const [epochs, setEpochs] = useState([]);
    const [authors, setAuthors] = useState([]);
    const [artPieces, setArtPieces] = useState([]);
    const [selectedArtPiece, setSelectedArtPiece] = useState(1);
    const [selectedEpoch, setSelectedEpoch] = useState(1);
    const [selectedAuthor, setSelectedAuthor] = useState(1);
    const [selectedArtisticMovement, setSelectedArtisticMovement] = useState(1);

    const handleClick = async () => {
        console.log(selectedOption);
        if (selectedOption == 1) {
            axios.put('http://localhost:8082/artPiece/updateArtPieceDescription?' +
                'id=' + selectedArtPiece + "&desc=" + text).then((response) => {
                    if (response.data) {
                        console.log('Text updated');
                    }
                }).catch((error) => {
                    console.log(error)
                })
        } else if (selectedOption == 2) {
            axios.put('http://localhost:8082/epoch/updateEpochTexts?' +
                'id=' + selectedEpoch + "&gen=" + selectGenerality + "&text=" + text).then((response) => {
                    if (response.data) {
                        console.log('Text updated');
                    }
                }).catch((error) => {
                    console.log(error)
                })
        }
        else if (selectedOption == 3) {
            axios.put('http://localhost:8082/author/updateAuthorTexts?' +
                'id=' + selectedAuthor + "&gen=" + selectGenerality + "&text=" + text).then((response) => {
                    if (response.data) {
                        console.log('Text updated');
                    }
                }).catch((error) => {
                    console.log(error)
                })
        }
        else {
            axios.put('http://localhost:8082/artisticMovement/updateArtisticMovementTexts?' +
                'id=' + selectedArtisticMovement + "&gen=" + selectGenerality + "&text=" + text).then((response) => {
                    if (response.data) {
                        console.log('Text updated');
                    }
                }).catch((error) => {
                    console.log(error)
                })
        }

    }

    const loadEpochs = async () => {
        const response = await axios.get('http://localhost:8082/epoch/getAll');
        if (response.data) {
            setEpochs(response.data.map((epoch: any) => { return { id: epoch.id, value: epoch.epochName } }));
        }
        else {
            console.log('Error loading epochs');
        }
    }

    const loadAuthors = async () => {
        const response = await axios.get('http://localhost:8082/author/getAll');
        if (response.data) {
            setAuthors(response.data.map((author: any) => { return { id: author.id, value: author.nameAuthor } }));
        }
        else {
            console.log('Error loading authors');
        }
    }

    const loadAllArtPieces = async () => {
        const response = await axios.get('http://localhost:8082/artPiece/getAll');
        if (response.data) {
            setArtPieces(response.data.map((artPiece: any) => { return { id: artPiece.id, value: artPiece.name } }));
        }
        else {
            console.log('Error loading art pieces');
        }
    }

    const loadArtisticMovement = async () => {
        const response = await axios.get('http://localhost:8082/artisticMovement/getAll');
        if (response.data) {
            setArtisticMovements(response.data.map((movement: any) => { return { id: movement.id, value: movement.movementName } }));
        }
        else {
            console.log('Error loading artistic movements');
        }
    }

    useEffect(() => {
        if (selectedOption === 1) {
            loadAllArtPieces();
        } else if (selectedOption === 2) {
            loadEpochs();
        } else if (selectedOption === 3) {
            loadAuthors();
        } else {
            loadArtisticMovement();
        }
    }, [selectedOption])

    const loadContent = () => {
        loadArtisticMovement();
        loadEpochs();
        loadAuthors();
        loadAllArtPieces();
    }

    if (!isInitialized) {
        loadContent();
        setIsInitialized(true);
    }

    const loadPageContent = () => {
        if (selectedOption == 1) {
            return (
                <>
                    <Dropdown handleChange={setSelectedArtPiece} value={selectedArtPiece} headerText="Choose art piece" options={artPieces} />
                    <TextareaComponent label="New text" placeholder="Enter new text here" value={text} onChange={(e: any) => setText(e.target.value)} />
                    <Button label="Update" size="medium" isEnabeld={text !== ""} onClick={() => handleClick()} />
                </>
            );
        } else if (selectedOption == 2) {
            return (
                <>
                    <Dropdown handleChange={setSelectGenerality} value={selectGenerality} headerText="Choose generality you whant to update"
                        options={[{ id: 1, value: "Local Tourist" }, { id: 2, value: "Serbian Tourist" }, { id: 3, value: "European Tourist" }]} />
                    <Dropdown handleChange={setSelectedEpoch} value={selectedEpoch} headerText="Choose epoch" options={epochs} />
                    <TextareaComponent label="New text" placeholder="Enter new text here" value={text} onChange={(e: any) => setText(e.target.value)} />
                    <Button label="Update" size="medium" isEnabeld={text !== ""} onClick={() => handleClick()} />
                </>

            );
        } else if (selectedOption == 3) {
            return (
                <>
                    <Dropdown handleChange={setSelectGenerality} value={selectGenerality} headerText="Choose generality you whant to update"
                        options={[{ id: 1, value: "Local Tourist" }, { id: 2, value: "Serbian Tourist" }, { id: 3, value: "European Tourist" }]} />
                    <Dropdown handleChange={setSelectedAuthor} value={selectedAuthor} headerText="Choose author" options={authors} />
                    <TextareaComponent label="New text" placeholder="Enter new text here" value={text} onChange={(e: any) => setText(e.target.value)} />
                    <Button label="Update" size="medium" isEnabeld={text !== ""} onClick={() => handleClick()} />
                </>
            );
        }
        else {
            return (
                <>
                    <Dropdown handleChange={setSelectGenerality} value={selectGenerality} headerText="Choose generality you whant to update"
                        options={[{ id: 1, value: "Local Tourist" }, { id: 2, value: "Serbian Tourist" }, { id: 3, value: "European Tourist" }]} />
                    <Dropdown handleChange={setSelectedArtisticMovement} value={selectedArtisticMovement} headerText="Choose artistic movement" options={artisticMovements} />
                    <TextareaComponent label="New text" placeholder="Enter new text here" value={text} onChange={(e: any) => setText(e.target.value)} />
                    <Button label="Update" size="medium" isEnabeld={text !== ""} onClick={() => handleClick()} />
                </>
            );
        }
    }
    return (
        <div className='route-create-container-outer'>
            <div className="route-create-container">
                <h1>Update Text</h1>
                <Dropdown handleChange={setSelectedOption} value={selectedOption}
                    headerText="Choose what you want to update" options={[{ id: 1, value: "Art piece" }, { id: 2, value: "Epoch" }, { id: 3, value: "Author" }, { id: 4, value: "Artistic movement" }]} />
                {loadPageContent()}
            </div>
        </div>
    );
}