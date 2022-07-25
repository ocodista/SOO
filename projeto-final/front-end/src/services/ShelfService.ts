import { AxiosInstance } from './AxiosInstance'
import { CadastroEstanteType, EstanteType, NichoType } from './types'

export class ShelfService {
  private static readonly axios = AxiosInstance()

  static async getAllShelfs (): Promise<EstanteType[]> {
    try {
      const response = await ShelfService.axios.get<EstanteType[]>('/estante/')
      // const response = { data: EstanteMock }
      return response.data
    } catch (error) {
      throw new Error('Erro ao buscar as estantes')
    }
  }

  static async createShelf (data: CadastroEstanteType): Promise<number> {
    try {
      const response = await ShelfService.axios.post('/estante/', { ...data })
      return response.data
    } catch (error) {
      throw new Error('Erro ao buscar as estantes')
    }
  }

  static async getAllNiches (): Promise<NichoType[]> {
    try {
      const response = await ShelfService.axios.get<NichoType[]>('/nicho/')
      return response.data
    } catch (error) {
      throw new Error('Erro ao buscar as estantes')
    }
  }
}
