import fs from 'fs'

export const readJsonFile = (filePath) => {
  const rawData = fs.readFileSync(filePath)
  return JSON.parse(filePath)
}