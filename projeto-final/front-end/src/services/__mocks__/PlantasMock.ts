import { PlantaType } from '../types'
import { CategoriaPlantaMock } from './CategoriaPlantaMock'

export const PlantasMock: PlantaType[] = [
  {
    id: 1,
    dataPlantio: new Date().getTime(),
    categoriaPlanta: CategoriaPlantaMock[2],
    idNicho: 1,
    nome: 'Rosa'
  }
]
