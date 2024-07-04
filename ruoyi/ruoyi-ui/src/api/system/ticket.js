import request from '@/utils/request'

// 查询票务列表
export function listTicket(query) {
  return request({
    url: '/system/ticket/list',
    method: 'get',
    params: query
  })
}

// 查询票务详细
export function getTicket(ticketId) {
  return request({
    url: '/system/ticket/' + ticketId,
    method: 'get'
  })
}

// 新增票务
export function addTicket(data) {
  return request({
    url: '/system/ticket',
    method: 'post',
    data: data
  })
}

// 修改票务
export function updateTicket(data) {
  return request({
    url: '/system/ticket',
    method: 'put',
    data: data
  })
}

// 删除票务
export function delTicket(ticketId) {
  return request({
    url: '/system/ticket/' + ticketId,
    method: 'delete'
  })
}
