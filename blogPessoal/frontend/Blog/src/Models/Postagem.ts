import Temas from './Temas';

interface Postagem{
    id: number;
    titulo: string;
    texto: string;
    tema?: Temas|null;

}
export default Postagem;