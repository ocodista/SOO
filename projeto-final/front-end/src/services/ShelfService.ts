import { AxiosInstance } from './AxiosInstance'
import { CadastroEstanteType, EstanteType, NichoType } from './types'
import { EstanteMock } from './__mocks__/EstanteMock'

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

  static async createShelf (data: CadastroEstanteType): Promise<void> {
    try {
      await ShelfService.axios.post('/estante/', { ...data })
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
