import { useLocation } from "react-router-dom";

export const CRSortByPage = () => {
    const state = useLocation();
    const { artPieces } = state.state;
    console.log(artPieces);

    return (
        <div>
            <h1>Sort By Page</h1>
        </div>
    );
}